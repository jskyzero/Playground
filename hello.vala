public class MyApp : Gtk.Application {
  
      public MyApp () {
          Object (application_id: "com.github.myteam.myapp",
          flags: ApplicationFlags.FLAGS_NONE);
      }
  
      protected override void activate () {
          var window = new Gtk.ApplicationWindow (this);
          window.title = "hello";
          window.set_default_size (1024, 768);
          window.show_all ();
      }
  
      public static int main (string[] args) {
          var app = new MyApp ();
          return app.run (args);
      }
  }