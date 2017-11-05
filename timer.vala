using Gtk;

public class MyApp: Gtk.Application {
  private Window window;
  private uint timerID;

  public MyApp () throws Error {
    //  var builder = new Builder ();
    //  builder.add_from_file ("gui.xml");
    //  builder.set_application(this);
    //  var builder = new Builder ();
    //  builder.add_from_file ("gui.xml");
    //  builder.connect_signals (this);
    //  this.window = builder.get_object ("win_main") as Window;
    window = new Gtk.ApplicationWindow (this);
    window.set_default_size (400, 400);
		window.title = "My Gtk.Application";
    this.window.destroy.connect(Gtk.main_quit);
  }

  public void run () {
    this.window.show_all ();
    Gtk.main ();
  }

  //  //This should activate the timer.
  //  [CCode (instance_pos = -1)]
  //  public void on_btnActivate_clicked (Button source) {
  //    timerID = Timeout.add (1000, on_timer_event);
  //  }

  //  //This should deactivate the timer..
  //  [CCode (instance_pos = -1)]
  //  public void on_btnDeactivate_clicked (Button source) {
  //    Source.remove (timerID);
  //  }

  //  //Timer listener
  //  public bool on_timer_event () {
  //    stdout.printf ("timer event");
  //    return true;
  //  }
}

int main (string[] args) {
  Gtk.init (ref args);
  try {
    var app = new MyApp ();
    app.run ();
  } catch (Error e) {
    stderr.printf ("Could not load UI: %s\n", e.message);
    return 1;
  }
  return 0;
}