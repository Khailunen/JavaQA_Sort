package ru.netology.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    public void searchOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14);
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8);

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("AER", "KLG");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchMoreTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14); //*
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14); //*
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13); //*
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9); //*
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8);

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1, ticket3, ticket5, ticket0,ticket7};
        Ticket[] actual = manager.search("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14);
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8);

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("KLG", "MSK");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void searchOneTicketForTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14);
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8);

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchAndSortBy("AER", "KLG", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchMoreTicketsForTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14); //*2h
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14); //* 2h
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13); //*3h
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9); //*2h
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8); //*3h

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket0, ticket1, ticket5, ticket3, ticket7};
        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchZeroTicketsForTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket0 = new Ticket("SPB", "MSK", 9_050, 12, 14);
        Ticket ticket1 = new Ticket("SPB", "MSK", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("AER", "KLG", 8_000, 9, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 5_000, 10, 13);
        Ticket ticket4 = new Ticket("MSK", "ARH", 12_000, 4, 8);
        Ticket ticket5 = new Ticket("SPB", "MSK", 9_000, 7, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 30_000, 14, 18);
        Ticket ticket7 = new Ticket("SPB", "MSK", 29_000, 5, 8);

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("KLG", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
}