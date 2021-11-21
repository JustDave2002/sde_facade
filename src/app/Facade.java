package app;

public class Facade {
    private Amplifier amp;
    private CdPlayer cdPlayer;
    private DvdPlayer dvdPlayer;
    private PopcornPopper popcornPopper;
    private Projector projector;
    private Screen screen;
    private TheaterLights theaterLights;
    private Tuner tuner;

    public Facade() {
        amp = new Amplifier("Top-O-Line Amplifier");
        tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
        dvdPlayer = new DvdPlayer("Top-O-Line DVD Player", amp);
        cdPlayer = new CdPlayer("Top-O-Line CD Player", amp);
        projector = new Projector("Top-O-Line Projector", dvdPlayer);
        theaterLights = new TheaterLights("Theater Ceiling Lights");
        screen = new Screen("Theater Screen");
        popcornPopper = new PopcornPopper("Popcorn Popper");
    }

    public void watchAMovie() {
        popcornPopper.on();
        popcornPopper.pop();
        theaterLights.dim(1);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvdPlayer);
        dvdPlayer.insert("Frozen");
        amp.setSurroundSound();
        amp.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play();
    }

    public void doneWithMovie() {
        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amp.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }

    public void listenToMusic() {
        theaterLights.on();
        amp.on();
        amp.setVolume(5);
        amp.setCd(cdPlayer);
        cdPlayer.insert("We Stitch These Wounds");
        amp.setStereoSound();
        cdPlayer.on();
        cdPlayer.play();
    }

    public void doneWithMusic() {
        amp.off();
        cdPlayer.eject();
        cdPlayer.off();
    }

    public void listenToRadio() {
        tuner.on();
        tuner.setFrequency(21);
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void doneWithRadio() {
        tuner.off();
        amp.off();
    }
}
