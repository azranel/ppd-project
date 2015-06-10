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
wycieczka(francja, paryz, miasto, wieza, 1700, 2, samolot, all_inclusive, hotel).

wycieczka(francja, nicea, miasto, morze, 2500, 5, samolot, all_inclusive, hotel).
wycieczka('wielka brytania', londyn, miasto, 'park rozrywki', 1000, 3, autokar, brak, hotel).
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
