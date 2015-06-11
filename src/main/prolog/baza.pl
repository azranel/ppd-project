krajowa(polska).

zagraniczna(X) :- X \= polska.

rejon(polska, gory).
rejon(polska, morze).
rejon(polska, jezioro).
rejon(polska, miasto).
rejon(polska, wies).
rejon(polska, las).
rejon(polska, park).
rejon(polska, zoo).
rejon(polska, zamek).
rejon(niemcy, gory).
rejon(niemcy, morze).
rejon(niemcy, jezioro).
rejon(niemcy, miasto).
rejon(niemcy, zamek).
rejon(czechy, miasto).
rejon(austria, gory).
rejon(austria, miasto).

pobytowa(gory).
pobytowa(morze).
pobytowa(jezioro).
pobytowa(miasto).

objazdowa(X) :- not(pobytowa(X)).

atrakcje(torun, teleskop).
atrakcje(torun, zamek).
atrakcje(poznan, cytadela).
atrakcje(gniezno, brama).
atrakcje(mogilno, ufo).

% wycieczka(kraj, miasto, rejon, atrakcje, koszt, ilu_dniowa, transport, wyzywienie, zakwaterowanie).
wycieczka(polska, torun, miasto, zamek, 700, 5, autokar, sniadanie, hotel).
wycieczka(polska, swinoujscie, morze, plaza, 1400, 7, pociag, sniadanie, osrodek).
wycieczka(polska, gniezno, miasto, brama, 300, 1, samochod, brak, brak).
wycieczka(polska, zakopane, miasto, gory, 1000, 7, pociag, all_inclusive, hotel).
wycieczka(polska, zakopane, miasto, gory, 1100, 7, samochod, all_inclusive, hotel).
wycieczka(polska, zakopane, miasto, gory, 1200, 10, pociag, all_inclusive, hotel).
wycieczka(polska, zakopane, miasto, gory, 1400, 10, samochod, all_inclusive, hotel).
wycieczka(tunezja, nabul, miasto, morze, 1700, 11, samolot, sniadanie, hotel).
wycieczka(tunezja, nabul, miasto, morze, 1300, 7, samolot, sniadanie, hotel).
wycieczka(tunezja, nabul, miasto, morze, 2000, 11, samolot, all_inclusive, hotel).
wycieczka(tunezja, kabis, miasto, morze, 1400, 7, samolot, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 2400, 10, samochod, all_inclusive, hotel).
wycieczka(niemcy, berlin, miasto, zabytki, 150, 1, pociag, brak, brak).
wycieczka(niemcy, berlin, miasto, zabytki, 3200, 14, samolot, all_inclusive, hotel).
wycieczka(niemcy, monachium, miasto, zabytki, 2400, 10, samochod, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).

wycieczka(francja, nicea, miasto, morze, 2500, 5, samolot, all_inclusive, hotel).
wycieczka(wielka_brytania, londyn, miasto, park_rozrywki, 1000, 3, autokar, brak, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).

krajowa(M, R, A, K, D, T, W, Z) :- wycieczka(polska, M, R, A, K, D, T, W, Z).
zagraniczna(M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), KR \= polska.

%cena_max(MAX_CENA, ..). cena_max(MAX_CENA, ILOSC_OSOB, ..).
cena_max(X, KR, M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), K =< X.
cena_max(X, Y, KR, M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), K*Y =< X.

dluzsza_niz(X, KR, M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), X > D.
krotsza_niz(X, KR, M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), X < D.
conajmniej(X, KR, M, R, A, K, D, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), X >= D.

znajdz_wycieczke(KR, M, R, A, K, K_MIN, K_MAX, D, D_MIN, D_MAX, T, W, Z) :- wycieczka(KR, M, R, A, K, D, T, W, Z), K >= K_MIN, K =< K_MAX, D >= D_MIN, D =< D_MAX.