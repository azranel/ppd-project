% wycieczka(kraj, miasto, rejon, atrakcje, koszt, ilu_dniowa, transport, wyzywienie, zakwaterowanie).

znajdz_wycieczke(KR, M, R, A, K, K_MIN, K_MAX, D, D_MIN, D_MAX, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), K >= K_MIN, K =< K_MAX, D >= D_MIN, D =< D_MAX.

wycieczka(czechy, praga, miasto, zabytki, 1500, 8, wlasny, sniadanie, hotel).
wycieczka(czechy, praga, miasto, zabytki, 2200, 8, wlasny, all_inclusive, hotel).
wycieczka(czechy, praga, miasto, zabytki, 2500, 8, autokar, sniadanie, hotel).
wycieczka(czechy, praga, miasto, zabytki, 3200, 8, autokar, all_inclusive, hotel).
wycieczka(czechy, praga, miasto, zabytki, 5500, 14, autokar, sniadanie, hotel).
wycieczka(czechy, praga, miasto, zabytki, 6200, 14, autokar, all_inclusive, hotel).

wycieczka(francja, nicea, miasto, morze, 2500, 5, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, marsylia, miasto, plaza, 2500, 2, samolot, all_inclusive, hotel).
wycieczka(francja, marsylia, miasto, winnice, 3500, 5, autokar, sniadanie, domek).
wycieczka(francja, marsylia, miasto, winnice, 4700, 5, samolot, sniadanie, domek).
wycieczka(francja, marsylia, miasto, winnice, 6400, 5, samolot, all_inclusive, hotel).
wycieczka(francja, marsylia, miasto, winnice, 6000, 11, autokar, sniadanie, domek).
wycieczka(francja, marsylia, miasto, winnice, 7000, 11, samolot, sniadanie, domek).
wycieczka(francja, marsylia, miasto, winnice, 9000, 11, samolot, all_inclusive, hotel).

wycieczka(islandia, reikjavik, miasto, natura, 10000, 12, prom, all_inclusive, hotel).
wycieczka(islandia, reikjavik, miasto, natura, 8000, 10, samolot, all_inclusive, hotel).

wycieczka(niemcy, berlin, miasto, zabytki, 80, 1, wlasny, brak, brak).
wycieczka(niemcy, berlin, miasto, zabytki, 150, 1, pociag, brak, brak).
wycieczka(niemcy, berlin, miasto, zabytki, 2400, 10, wlasny, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 1500, 7, pociag, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 1800, 7, pociag, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 1800, 7, autokar, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2200, 7, autokar, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2200, 7, samolot, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2500, 7, samolot, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2500, 14, pociag, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2800, 14, pociag, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2800, 14, autokar, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 3000, 14, autokar, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 3000, 14, samolot, sniadanie, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 3200, 14, samolot, all_inclusive, hotel).
wycieczka(niemcy, monachium, miasto, zabytki, 1800, 10, wlasny, sniadanie, hotel).
wycieczka(niemcy, monachium, miasto, zabytki, 2200, 10, autokar, sniadanie, hotel).
wycieczka(niemcy, monachium, miasto, zabytki, 2400, 10, wlasny, all_inclusive, hotel).
wycieczka(niemcy, monachium, miasto, zabytki, 2800, 10, autokar, all_inclusive, hotel).
wycieczka(niemcy, monachium, miasto, zamek, 3000, 10, wlasny, sniadanie, hotel).
wycieczka(niemcy, monachium, miasto, zamek, 3400, 10, autokar, sniadanie, hotel).
wycieczka(niemcy, monachium, miasto, zamek, 3400, 10, wlasny, all_inclusive, hotel).
wycieczka(niemcy, monachium, miasto, zamek, 3800, 10, autokar, all_inclusive, hotel).

wycieczka(norwegia, oslo, miasto, natura, 2500, 4, prom, sniadanie, hotel).
wycieczka(norwegia, oslo, miasto, natura, 3250, 4, prom, all_inclusive, hotel).
wycieczka(norwegia, oslo, miasto, natura, 5750, 8, prom, sniadanie, hotel).
wycieczka(norwegia, oslo, miasto, natura, 7000, 8, prom, all_inclusive, hotel).
wycieczka(norwegia, oslo, miasto, natura, 10000, 13, samolot, all_inclusive, hotel).
wycieczka(norwegia, oslo, miasto, natura, 15000, 20, samolot, all_inclusive, hotel).

wycieczka(polska, torun, miasto, zamek, 100, 1, autokar, brak, brak).
wycieczka(polska, torun, miasto, zamek, 200, 5, wlasny, brak, schronisko).
wycieczka(polska, torun, miasto, zamek, 300, 5, autokar, brak, schronisko).
wycieczka(polska, torun, miasto, zamek, 600, 5, autokar, brak, hotel).
wycieczka(polska, torun, miasto, zamek, 700, 5, autokar, sniadanie, hotel).
wycieczka(polska, swinoujscie, morze, plaza, 1400, 7, pociag, sniadanie, osrodek).
wycieczka(polska, swinoujscie, morze, plaza, 2400, 7, autokar, sniadanie, hotel).
wycieczka(polska, swinoujscie, morze, plaza, 3400, 7, autokar, all_inclusive, hotel).
wycieczka(polska, gniezno, miasto, brama, 100, 1, autokar, brak, brak).
wycieczka(polska, gniezno, miasto, brama, 200, 2, wlasny, brak, osrodek).
wycieczka(polska, gniezno, miasto, brama, 300, 2, wlasny, sniadanie, osrodek).
wycieczka(polska, zakopane, gory, natura, 1000, 7, pociag, all_inclusive, hotel).
wycieczka(polska, zakopane, gory, natura, 1100, 7, wlasny, all_inclusive, hotel).
wycieczka(polska, zakopane, gory, natura, 1200, 10, pociag, all_inclusive, hotel).
wycieczka(polska, zakopane, gory, natura, 1400, 10, wlasny, all_inclusive, hotel).

wycieczka(portugalia, azory, wyspa, plaza, 6000, 8, samolot, sniadanie, hotel).
wycieczka(portugalia, azory, wyspa, plaza, 6800, 8, samolot, all_inclusive, hotel).
wycieczka(portugalia, azory, wyspa, plaza, 10000, 16, samolot, sniadanie, hotel).
wycieczka(portugalia, azory, wyspa, plaza, 18000, 16, samolot, all_inclusive, hotel).

wycieczka(rosja, kaliningrad, miasto, zabytki, 2500, 5, autokar, sniadanie, hotel).
wycieczka(rosja, kaliningrad, miasto, zabytki, 3000, 5, autokar, all_inclusive, hotel).
wycieczka(rosja, kaliningrad, miasto, zabytki, 3500, 8, autokar, sniadanie, hotel).
wycieczka(rosja, kaliningrad, miasto, zabytki, 4500, 8, autokar, all_inclusive, hotel).
wycieczka(rosja, moskwa, miasto, park_rozrywki, 1000, 4, pociag, sniadanie, hotel).

wycieczka(tunezja, nabul, morze, plaza, 1700, 11, samolot, sniadanie, hotel).
wycieczka(tunezja, nabul, morze, plaza, 1300, 7, samolot, sniadanie, hotel).
wycieczka(tunezja, nabul, morze, plaza, 2000, 11, samolot, all_inclusive, hotel).
wycieczka(tunezja, nabul, morze, plaza, 1600, 7, samolot, all_inclusive, hotel).
wycieczka(tunezja, kabis, morze, plaza, 1100, 7, samolot, sniadanie, hotel).
wycieczka(tunezja, kabis, morze, plaza, 1700, 13, samolot, sniadanie, hotel).
wycieczka(tunezja, kabis, morze, plaza, 1400, 7, samolot, all_inclusive, hotel).
wycieczka(tunezja, kabis, morze, plaza, 2000, 13, samolot, all_inclusive, hotel).

wycieczka(turcja, bodrum, morze, plaza, 2000, 7, samolot, sniadanie, hotel).
wycieczka(turcja, bodrum, morze, plaza, 2700, 7, samolot, all_inclusive, hotel).
wycieczka(turcja, bodrum, morze, plaza, 3700, 13, samolot, sniadanie, hotel).
wycieczka(turcja, bodrum, morze, plaza, 6000, 13, samolot, all_inclusive, hotel).
wycieczka(turcja, kusadasi, morze, plaza, 3000, 7, samolot, sniadanie, hotel).
wycieczka(turcja, kusadasi, morze, plaza, 3700, 7, samolot, all_inclusive, hotel).
wycieczka(turcja, kusadasi, morze, plaza, 4700, 13, samolot, sniadanie, hotel).
wycieczka(turcja, kusadasi, morze, plaza, 10000, 13, samolot, all_inclusive, hotel).

wycieczka(wielka_brytania, londyn, miasto, park_rozrywki, 1000, 3, autokar, brak, hotel).
wycieczka(wielka_brytania, londyn, miasto, park_rozrywki, 1200, 3, autokar, sniadanie, hotel).
wycieczka(wielka_brytania, londyn, miasto, park_rozrywki, 1700, 3, autokar, all_inclusive, hotel).
wycieczka(wielka_brytania, londyn, miasto, park_rozrywki, 2700, 3, samolot, all_inclusive, hotel).

wycieczka(wlochy, mediolan, miasto, zabytki, 3600, 8, wlasny, all_inclusive, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 4500, 8, autokar, sniadanie, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 4900, 8, autokar, all_inclusive, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 5600, 8, samolot, all_inclusive, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 7200, 18, wlasny, all_inclusive, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 9000, 18, autokar, sniadanie, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 9800, 18, autokar, all_inclusive, hotel).
wycieczka(wlochy, mediolan, miasto, zabytki, 11200, 18, samolot, all_inclusive, hotel).

