package Interface.ScreenLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoadKit {

    private Parent next_root;
    private Controller next_controller;

    // constructeurs

    public LoadKit () {

    }

    public LoadKit (Parent s, Controller c) {
        this.next_root = s;
        this.next_controller = c;
    }

    // getter

    public Parent getNext_root () {
        return next_root;
    }

    public Controller getNext_controller () {
        return next_controller;
    }

    // setter

    public void setNext_controller(Controller next_controller) {
        this.next_controller = next_controller;
    }

    public void setNext_root(Parent next_scene) {
        this.next_root = next_scene;
    }
}
