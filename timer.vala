using Gtk;

public class Timer{
  private Window window;
  private Builder builder;
  private bool canUpdate;
  private int64 initialSec;

  public Timer () throws Error {
    canUpdate = false;
    builder = new Builder ();
    builder.add_from_file ("UI.glade");
    builder.connect_signals (this);
    this.window = builder.get_object ("window") as Window;
    this.window.destroy.connect(Gtk.main_quit);

    var thread = new Thread<void*>.try("test", updateTimer);
  }

  public void run () {
    this.window.show_all ();
    Gtk.main ();
  }

  [CCode (instance_pos = -1)]
  public void button_click(Button source) {
    canUpdate = !canUpdate;
    source.label = canUpdate ? "click to stop" : "click to start";
    initialSec = (new GLib.DateTime.now_local()).to_unix();
  }

  private void* updateTimer() {
    while (true) {
      if (canUpdate) {
        var label = builder.get_object ("timer") as Label;
        var now = new GLib.DateTime.now_local();
        var sec = now.to_unix();
        var msec = now.get_microsecond ();
        label.label = (sec - initialSec).to_string() + "." + msec.to_string();
      }
      Thread.usleep(1* 1000 * 1000);
    }
    return null;
  }

}

int main (string[] args) {
  Gtk.init (ref args);
  try {
    var app = new Timer ();
    app.run ();
  } catch (Error e) {
    stderr.printf ("Could not load UI: %s\n", e.message);
    return 1;
  }
  return 0;
}