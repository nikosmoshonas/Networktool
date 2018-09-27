/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networktool.NetworkTool.view;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import networktool.NetworkTool.model.Network;

/**
 * FXML Controller class
 *
 * @author Nikos
 */
public class NetworkToolController implements Initializable {

    String ipp = "";

    @FXML
    private Label privateip;

    @FXML
    private Label hostname1;

    @FXML
    private Label publicip;

    Network n = new Network();

    @FXML

    public void clickbuttonforipandlocation() throws SocketException, UnknownHostException, MalformedURLException, IOException, InterruptedException {

        InetAddress ip = InetAddress.getLocalHost();
        String host1 = ip.getHostAddress();
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();

            privateip.setText(host1);
            hostname1.setText(hostname);

            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

            n.alert(host1, host1, "local");

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        URL whatismyip = new URL("http://icanhazip.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        ipp = in.readLine(); //you get the IP as a String
        System.out.println(ipp);
        publicip.setText(ipp);
        

        n.alert(ipp, ipp, "public");

        /*String host = "localhost";
        InetAddress inetAddress = InetAddress.getByName(host);

        String hostName = inetAddress.getHostName();
        for (int port = 0; port <= 65535; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                System.out.println(text);
                socket.close();
            } catch (IOException e) {
                String s = hostName + " is not listening on port " + port;
                System.out.println(s);
            }
        }
         */
    }

    @FXML
    public void clearButto() {

        privateip.setText("");
        hostname1.setText("");
        publicip.setText("");

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void getLocation(ActionEvent event) {

        String i = "https://geoiptool.com/de/?ip=";
        String y;
        y = i + this.ipp;

        System.out.println(y);

        try {
            Desktop.getDesktop().browse(new URL(y).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
