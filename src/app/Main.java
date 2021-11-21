package app;

public class Main {

    public static void main(String[] args) {
      Facade facade = new Facade();

      facade.watchAMovie();
      facade.doneWithMovie();

      facade.listenToMusic();
      facade.doneWithMusic();

      facade.listenToRadio();
      facade.doneWithRadio();
    }
}
