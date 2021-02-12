package javaStart.task40_CollectionProcessing.exercise2;

import javaStart.task40_CollectionProcessing.exercise2.Song.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Genre.POP)
        );

        int totalDuration = totalLengthByGenre(songs, Genre.POP);
        printLine("The total duration of the pop songs is: " + totalDuration);
        long numberTracks = getTrackArtist(songs, "Metallica");
        printLine("The number songs of Metallica is: " + numberTracks);
        List<Song> songsWithoutPop = getSongsWithoutRemovedGenre(songs, Genre.POP);
        printLine("Songs without Pop songs:");
        songsWithoutPop.forEach(System.out::println);
    }

    private static int totalLengthByGenre(List<Song> list, Song.Genre genre) {
        return list.stream()
                .filter(song -> song.getGenre().equals(genre))
                .mapToInt(Song::getLength)
                .sum();
    }

    private static long getTrackArtist(List<Song> list, String name) {
        return list.stream()
                .filter(song -> song.getArtist().equals(name))
                .count();
    }

    private static List<Song> getSongsWithoutRemovedGenre(List<Song> list, Song.Genre genre) {
        return list.stream()
                .filter(song -> !song.getGenre().equals(genre))
                .distinct()
                .collect(Collectors.toList());
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
