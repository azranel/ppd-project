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
    private JTextField priceMin;
    private JTextField priceMax;
    private PrologAsker prologAsker;

    public MainFrame(PrologAsker prolog) {
        super();
        prologAsker = prolog;
        setTitle("PPD Project");
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

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

        priceMin = new JTextField();
        priceMax = new JTextField();

        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(2, 2));
        pricePanel.add(new JLabel("Od: "));
        pricePanel.add(priceMin);
        pricePanel.add(new JLabel("Do: "));
        pricePanel.add(priceMax);
        pricePanel.setBorder(BorderFactory.createTitledBorder("Cena"));
        listsPanel.add(pricePanel);

        return listsPanel;
    }

    private JPanel buildResultsPanel() {
        JPanel resultsPanel = new JPanel();
        resultsTextArea = new JTextPane();
        resultsScrollPane = new JScrollPane(resultsTextArea);

        GridLayout layout = new GridLayout(2, 1);
        resultsPanel.setLayout(layout);
        resultsPanel.add(resultsScrollPane);
        resultsPanel.add(solutionButton);
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Rezultaty"));
        return resultsPanel;
    }

    private Map<String, JComboBox<String>> buildParametersLists() {
        Map<String, JComboBox<String>> result = new HashMap<>();

        Multimap<String, String> options = ArrayListMultimap.create();
        options.putAll("atrakcje", Arrays.asList(DOESNT_MATTER, "zamek", "jezioro", "morze", "park rozrywki"));
        options.putAll("kraj", Arrays.asList(DOESNT_MATTER, "polska", "niemcy", "rosja", "krym", "wielka brytania"));
        options.putAll("dojazd", Arrays.asList(DOESNT_MATTER, "autokar", "pociag", "samochod", "samolot", "prom"));
        // TODO More options

        for (String parameter : options.keySet()) {

            JComboBox<String> box = new JComboBox<>();

            for (String parameterOption : options.get(parameter))
                box.addItem(parameterOption);

            box.setVisible(true);
            result.put(parameter, box);
        }

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

        return properties;
    }

    public void printResults(Collection<String> results) {
        resultsTextArea.setText("");

        StringBuilder builder = new StringBuilder();
        for (String result : results)
            builder.append(result + "\n");

        resultsTextArea.setText(builder.toString());
    }

}
