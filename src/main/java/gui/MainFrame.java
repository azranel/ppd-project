package gui;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import prolog.asker.PrologAsker;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by azranel on 09.06.15.
 */
public class MainFrame extends JFrame {

    public final static String DOESNT_MATTER = "nie wazne";
    private JButton solutionButton;
    private JTextPane resultsTextArea;
    private JScrollPane resultsScrollPane;

    private Map<String, JComboBox<String>> parametersLists;
    private Multimap<String, String> citiesByCountry;

    @SuppressWarnings("Finally unused")
    private JTextField priceMin;

    private JTextField priceMax;

    @SuppressWarnings("Finally unused")
    private JTextField daysMin;

    private JTextField daysMax;
    private PrologAsker prologAsker;

    public MainFrame(PrologAsker prolog) {
        super();
        prologAsker = prolog;
        setTitle("PPD Project");
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        citiesByCountry = buildCitiesByCountry();
        solutionButton = buildSolutionButton();
        parametersLists = buildParametersLists();

        setLayout(new GridLayout());
        add(buildParametersPanel());
        add(buildResultsPanel());

        pack();
    }

    private JPanel buildParametersPanel() {
        JPanel listsPanel = new JPanel();
        GridLayout parametersPanelLayout = new GridLayout(parametersLists.size(), 1);
        listsPanel.setLayout(parametersPanelLayout);
        listsPanel.setBorder(BorderFactory.createTitledBorder("Parametry wycieczki"));

        for (String parameter : parametersLists.keySet()) {
            JPanel innerPanel = new JPanel();
            innerPanel.add(parametersLists.get(parameter));
            innerPanel.setBorder(BorderFactory.createTitledBorder(parameter));
            listsPanel.add(innerPanel);
        }


        listsPanel.add(addPricesPanel());
        listsPanel.add(addDaysPanel());

        return listsPanel;
    }

    private JPanel addDaysPanel() {
        daysMin = new JTextField();
        daysMax = new JTextField();
        JPanel dayePanel = new JPanel();
        dayePanel.setLayout(new GridLayout(2, 2));
        dayePanel.add(new JLabel("Od: "));
        dayePanel.add(daysMin);
        dayePanel.add(new JLabel("Do: "));
        dayePanel.add(daysMax);
        dayePanel.setBorder(BorderFactory.createTitledBorder("Liczba dni:"));
        return dayePanel;
    }

    private JPanel addPricesPanel() {
        priceMin = new JTextField();
        priceMax = new JTextField();
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(2, 2));
        pricePanel.add(new JLabel("Od: "));
        pricePanel.add(priceMin);
        pricePanel.add(new JLabel("Do: "));
        pricePanel.add(priceMax);
        pricePanel.setBorder(BorderFactory.createTitledBorder("Cena"));

        return pricePanel;
    }

    private JPanel buildResultsPanel() {
        JPanel resultsPanel = new JPanel();
        resultsTextArea = new JTextPane();
        resultsScrollPane = new JScrollPane(resultsTextArea);

        GridBagLayout layout = new GridBagLayout();
        resultsPanel.setLayout(layout);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.ipady = 300;
        c1.ipadx = 300;
        resultsPanel.add(resultsScrollPane, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        resultsPanel.add(solutionButton, c2);

        resultsPanel.setBorder(BorderFactory.createTitledBorder("Rezultaty"));
        return resultsPanel;
    }

    private Map<String, JComboBox<String>> buildParametersLists() {
        Map<String, JComboBox<String>> result = new HashMap<>();

        Multimap<String, String> options = ArrayListMultimap.create();
        options.putAll("atrakcje", Arrays.asList(DOESNT_MATTER, "zamek", "jezioro", "morze", "park rozrywki"));
        options.putAll("kraj", Arrays.asList(DOESNT_MATTER, "polska", "niemcy", "rosja", "krym", "wielka brytania"));
        options.putAll("miasto", Arrays.asList(DOESNT_MATTER));
        options.putAll("dojazd", Arrays.asList(DOESNT_MATTER, "autokar", "pociag", "samochod", "samolot", "prom"));
        options.putAll("wyzywienie", Arrays.asList(DOESNT_MATTER, "brak", "sniadanie", "all_inclusive"));
        options.putAll("zakwaterowanie", Arrays.asList(DOESNT_MATTER, "brak", "hotel", "schronisko", "domek"));
        // TODO More options

        for (String parameter : options.keySet()) {

            JComboBox<String> box = new JComboBox<>();

            for (String parameterOption : options.get(parameter))
                box.addItem(parameterOption);

            box.setVisible(true);
            result.put(parameter, box);
        }

        result.get("kraj").addActionListener(
                e -> {
                    Collection<String> cities = citiesByCountry.get((String) result.get("kraj").getSelectedItem());
                    // DefaultComboBoxModel needs String as array
                    String[] temporaryCities = new String[cities.size()];
                    citiesByCountry.get((String) result.get("kraj").getSelectedItem()).toArray(temporaryCities);
                    result.get("miasto").setModel(new DefaultComboBoxModel<String>(temporaryCities));
                }
        );

        return result;
    }

    private JButton buildSolutionButton() {
        JButton button = new JButton("Find solution");
        button.addActionListener(e -> printResults(prologAsker.getResults(getData())));
        button.setVisible(true);
        return button;
    }

    public Map<String, String> getData() {
        Map<String, String> properties = new HashMap<>();

        for (String parameter : parametersLists.keySet()) {
            JComboBox<String> pane = parametersLists.get(parameter);
            properties.put(parameter, (String) pane.getSelectedItem());
        }

        if (!priceMin.getText().isEmpty() &&
                priceMin.getText().matches("\\d+(\\.\\d+)?"))
            properties.put("cenaMin", priceMin.getText());

        if (!priceMax.getText().isEmpty() &&
                priceMax.getText().matches("\\d+(\\.\\d+)?"))
            properties.put("cenaMax", priceMax.getText());

        if (!daysMin.getText().isEmpty() &&
                daysMin.getText().matches("\\d+"))
            properties.put("dniMin", daysMin.getText());

        if (!daysMax.getText().isEmpty() &&
                daysMax.getText().matches("\\d+"))
            properties.put("dniMax", daysMax.getText());

        return properties;
    }

    public void printResults(Collection<String> results) {
        resultsTextArea.setText("");

        StringBuilder builder = new StringBuilder();
        for (String result : results)
            builder.append(result + "\n");

        resultsTextArea.setText(builder.toString());
    }


    private Multimap<String, String> buildCitiesByCountry() {
        Multimap<String, String> cities = ArrayListMultimap.create();

        cities.putAll(DOESNT_MATTER, Arrays.<String>asList(DOESNT_MATTER));
        cities.putAll("niemcy", Arrays.<String>asList("berlin", "hamburg", "dortmund", "strassburg"));
        cities.putAll("polska", Arrays.<String>asList("warszawa", "zakopane", "torun", "gdansk", "swinoujscie",
                "miedzyzdroje", "leba", "poznan", "szczecin", "olsztyn"));
        cities.putAll("rosja", Arrays.<String>asList("moskwa", "petersburg", "wladywostok", "irkuck"));
        cities.putAll("krym", Arrays.<String>asList("sewastopol"));
        cities.putAll("wielka brytania", Arrays.<String>asList("londyn", "edynburg", "manchester", "birmingham", "nottigham"));

        return cities;
    }

}
