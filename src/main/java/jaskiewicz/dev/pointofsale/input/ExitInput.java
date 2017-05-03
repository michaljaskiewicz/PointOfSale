package jaskiewicz.dev.pointofsale.input;

/**
 * Created by michaljaskiewicz on 03-May-17.
 */
public interface ExitInput {

    void exit();

    void assignCallback(Callback callback);

    interface Callback {

        void onExit();
    }
}