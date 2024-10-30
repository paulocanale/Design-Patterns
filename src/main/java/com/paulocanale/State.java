package com.paulocanale;

/**
 * State Pattern Example
 * 
 * The State pattern allows an object to change its behavior when its internal state
 * changes. 
 * This example demonstrates a music player with different behaviors depending on its 
 * state (Playing, Paused, Stopped).
 * 
 * Author: Paulo Canale <paulocanale@me.com>
 */

// State interface
interface PlayerState {
    void pressPlay(MusicPlayer player);
    void pressPause(MusicPlayer player);
    void pressStop(MusicPlayer player);
}

// Concrete State: PlayingState
class PlayingState implements PlayerState {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("The music is already playing.");
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("Pausing the music.");
        player.setState(new PausedState());
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("Stopping the music.");
        player.setState(new StoppedState());
    }
}

// Concrete State: PausedState
class PausedState implements PlayerState {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Resuming the music.");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("The music is already paused.");
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("Stopping the music from paused state.");
        player.setState(new StoppedState());
    }
}

// Concrete State: StoppedState
class StoppedState implements PlayerState {
    @Override
    public void pressPlay(MusicPlayer player) {
        System.out.println("Starting the music.");
        player.setState(new PlayingState());
    }

    @Override
    public void pressPause(MusicPlayer player) {
        System.out.println("Can't pause. The music is stopped.");
    }

    @Override
    public void pressStop(MusicPlayer player) {
        System.out.println("The music is already stopped.");
    }
}

// Context class: MusicPlayer
class MusicPlayer {
    private PlayerState state;

    public MusicPlayer() {
        this.state = new StoppedState(); // initial state
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void pressPause() {
        state.pressPause(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }
}

// Main class to demonstrate the State pattern
public class State {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Testing state transitions
        player.pressPlay();   // Starting the music
        player.pressPause();  // Pausing the music
        player.pressPlay();   // Resuming the music
        player.pressStop();   // Stopping the music
        player.pressPause();  // Trying to pause while stopped
    }
}
