package Interface.ScreenLoader;

import javafx.scene.Scene;

public class LoadKit {

    private Scene next_scene;
    private Controller next_controller;

    // constructeurs

    public LoadKit () {

    }

    public LoadKit (Scene s, Controller c) {
        this.next_scene = s;
        this.next_controller = c;
    }

    // getter

    public Scene getNext_scene () {
        return next_scene;
    }

    public Controller getNext_controller () {
        return next_controller;
    }

    // setter

    public void setNext_controller(Controller next_controller) {
        this.next_controller = next_controller;
    }

    public void setNext_scene(Scene next_scene) {
        this.next_scene = next_scene;
    }
}
