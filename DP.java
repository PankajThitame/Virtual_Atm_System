import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
//main class
public class DP extends Application
{
// Application starts  here
public void start( Stage st )
{
// set stage title
st.setTitle("creation of the date picker : ") ;
// Tile pane creation
TilePane tp = new TilePane() ;
// Date picker creation
DatePicker dp = new DatePicker();
// add both label and button
tp.getChildren().add(dp);
// scene creation
Scene sc = new Scene(tp, 200, 200);
// setting of the scene
st.setScene(sc);
//display the stage
st.show();
}
//main method
public static void main(String args[])
{
// application launches here
launch(args);
}
}