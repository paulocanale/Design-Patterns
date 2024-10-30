package com.paulocanale;

/**
 * Facade Pattern Example
 * 
 * The Facade pattern provides a simplified interface to a complex subsystem.
 * This example demonstrates a video conversion system where a facade class
 * offers a simplified way to perform video conversions.
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// Subsystem class: VideoDecoder
class VideoDecoder {
    public void decode(String filename) {
        System.out.println("Decoding video file: " + filename);
    }
}

// Subsystem class: VideoCompressor
class VideoCompressor {
    public void compress(String format) {
        System.out.println("Compressing video to format: " + format);
    }
}

// Subsystem class: VideoStorage
class VideoStorage {
    public void store(String filename) {
        System.out.println("Storing video file: " + filename);
    }
}

// Facade class: VideoConversionFacade
class VideoConversionFacade {
    private VideoDecoder decoder;
    private VideoCompressor compressor;
    private VideoStorage storage;

    public VideoConversionFacade() {
        this.decoder = new VideoDecoder();
        this.compressor = new VideoCompressor();
        this.storage = new VideoStorage();
    }

    public void convertVideo(String filename, String format) {
        System.out.println("Starting video conversion process...");
        decoder.decode(filename);
        compressor.compress(format);
        storage.store(filename);
        System.out.println("Video conversion completed.\n");
    }
}

// Main class to demonstrate the Facade pattern
public class Facade {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();

        // Use the facade to convert videos in a simplified way
        converter.convertVideo("my_video.mp4", "avi");
        converter.convertVideo("my_movie.mkv", "mp4");
    }
}
