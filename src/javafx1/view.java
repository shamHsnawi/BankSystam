/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx1;

import java.awt.Checkbox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author Windows.10
 */
public class view  extends Pane{
    
    
    
    
    public TabPane tabContainer=new TabPane();
    
    public TableView<model> table=new TableView<>();
    
    public Pane updatingPane=new Pane();
    public Tab updatingTab=new Tab("updating");
    
    Label imformation=new Label("insert customer imformation for updating:");
    Label enterCustomerID=new Label("enter customerID :");
    Label enterCustomerPhone=new Label("enter customer phone :");
    TextField tenterCustomerID=new TextField();
    TextField tenterCustomerPhone=new TextField();
    Button update =new Button("updating");
    
    
    
    
    
    public Pane sendPane=new Pane();
    public Tab sendTab=new Tab("Send");
    
    Label lb=new Label("insert your information:");
    Label full_name=new Label("full_name:");
    Label phone=new Label("phone number:");
    
    TextField tfull_name=new TextField();
    TextField tphone=new TextField();
    
    Button clear=new Button("clear");
    
    Label lb3=new Label("from branch:");
    public ComboBox<String> choice=new ComboBox<>();
    
    Label lbrecieve=new Label("select distination branch:");
    public ComboBox<String> choiceto=new ComboBox<>();
    
    
    Label amount=new Label("enter amount:");
    TextField tamount=new TextField();
    
    Label recieverPhone=new Label("reciever Phone:");
    TextField trecieverPhone=new TextField();
    
    Button b2=new Button("submet");
    
    
    public Tab recieveTab=new Tab("recieve");
    public Pane recievePane=new Pane();
    
    TextArea ta=new TextArea();
    
    Label lb2=new Label("insert your information:");
    Label full_name2=new Label("full_name:");
    Label phone2=new Label("phone number:");
    
    TextField tfull_name2=new TextField();
    TextField tphone2=new TextField();
    
    Button clear2=new Button("clear");
    
    Label notice=new Label("insert notice number :");
    TextField t1=new TextField();
    Button b3=new Button("submet");
    
    public Tab searchTab=new Tab("Search");
    public Pane searchPane=new Pane();
    
    Label getInfo2=new Label("get sender information by phone number");
    Label enterSenderPhone=new Label("insert sender phone : ");
    TextField tenterSenderPhone=new TextField();
    Button returnData =new Button("click here");
    
    Label getInfo=new Label("get sender information by sender ID");
    Button click=new Button("click here");
    Label senderID=new Label("insert sender ID : ");
    TextField tsenderID=new TextField();
    
    public view(){
        this.searchTab.setClosable(false);
        this.sendTab.setClosable(false);
        this.recieveTab.setClosable(false);
        this.updatingTab.setClosable(false);
        //
        String[] array={"Lattakia", "damascus", "Homs", "Hama", "Aleppo", "Tartous"};
        ObservableList<String> list=FXCollections.observableArrayList(array);
        this.choice.getItems().addAll(list);
        this.choiceto.getItems().addAll(list);
        attachLayout();
    }
    private void attachLayout(){
        initsendTab();
        initrecieveTab();
        initsearchTab();
        initupdateTap();
        this.tabContainer.getTabs().addAll(this.sendTab,this.recieveTab,this.searchTab,this.updatingTab);
        this.getChildren().add(this.tabContainer);
    }
    
    
    private void initsearchTab()
    {
        this.searchPane.getChildren().add(this.getInfo);
        this.getInfo.setLayoutX(20);
        this.getInfo.setLayoutY(20);
        
        this.searchPane.getChildren().add(this.senderID);
        this.senderID.setLayoutX(40);
        this.senderID.setLayoutY(80);
        
        this.searchPane.getChildren().add(this.tsenderID);
        this.tsenderID.setLayoutX(200);
        this.tsenderID.setLayoutY(80);
        
        this.searchPane.getChildren().add(this.click);
        this.click.setLayoutX(360);
        this.click.setLayoutY(80);
        
        this.searchPane.getChildren().add(this.getInfo2);
        this.getInfo2.setLayoutX(20);
        this.getInfo2.setLayoutY(160);
        
        this.searchPane.getChildren().add(this.returnData);
        this.returnData.setLayoutX(360);
        this.returnData.setLayoutY(220);
        
        this.searchPane.getChildren().add(this.enterSenderPhone);
        this.enterSenderPhone.setLayoutX(40);
        this.enterSenderPhone.setLayoutY(220);
        
        this.searchPane.getChildren().add(this.tenterSenderPhone);
        this.tenterSenderPhone.setLayoutX(200);
        this.tenterSenderPhone.setLayoutY(220);
        
        buildBookTable();
        this.searchPane.getChildren().add(this.table);
        this.table.setLayoutX(20);
        this.table.setLayoutY(300);
        
        this.searchTab.setContent(this.searchPane);
    }
        
    private void buildBookTable()
    {
        
        TableColumn<model, String> senderNameCol= new TableColumn("senderName");
        senderNameCol.setCellValueFactory(new PropertyValueFactory<>("senderName"));
        senderNameCol.setPrefWidth(100);
        this.table.getColumns().add(senderNameCol);
        
        TableColumn<model, Integer> senderPhoneCol= new TableColumn("senderPhone");
        senderPhoneCol.setCellValueFactory(new PropertyValueFactory<>("senderPhone"));
        senderPhoneCol.setPrefWidth(100);
        this.table.getColumns().add(senderPhoneCol);

        TableColumn<model, String> frombrunchCol= new TableColumn("frombrunch");
        frombrunchCol.setCellValueFactory(new PropertyValueFactory<>("frombrunch"));
        frombrunchCol.setPrefWidth(100);
        this.table.getColumns().add(frombrunchCol);
        
        TableColumn<model, String> tobrunchCol= new TableColumn("tobrunch");
        tobrunchCol.setCellValueFactory(new PropertyValueFactory<>("tobrunch"));
        tobrunchCol.setPrefWidth(100);
        this.table.getColumns().add(tobrunchCol);
        
        TableColumn<model, Integer> recieverPhoneCol= new TableColumn("recieverPhone");
        recieverPhoneCol.setCellValueFactory(new PropertyValueFactory<>("recieverPhone"));
        recieverPhoneCol.setPrefWidth(100);
        this.table.getColumns().add(recieverPhoneCol);
        
        TableColumn<model, Integer> amountCol= new TableColumn("amount");
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amountCol.setPrefWidth(100);
        this.table.getColumns().add(amountCol); 
        
        TableColumn<model, Integer> noticeCol= new TableColumn("notice");
        noticeCol.setCellValueFactory(new PropertyValueFactory<>("notice"));
        noticeCol.setPrefWidth(100);
        this.table.getColumns().add(noticeCol);
        
    }    

    private void initsendTab() { 

        lb.setLayoutX(40);
        lb.setLayoutY(40);
        
        full_name.setLayoutX(80);
        full_name.setLayoutY(80);
        tfull_name.setLayoutX(180);
        tfull_name.setLayoutY(80);
        
        phone.setLayoutX(80);
        phone.setLayoutY(120);
        tphone.setLayoutX(180);
        tphone.setLayoutY(120);
       
        lb3.setLayoutX(80);
        lb3.setLayoutY(160);
        
        choice.setLayoutX(230);
        choice.setLayoutY(160);
        
        lbrecieve.setLayoutX(80);
        lbrecieve.setLayoutY(220);
        
        choiceto.setLayoutX(230);
        choiceto.setLayoutY(220);
        
        recieverPhone.setLayoutX(80);
        recieverPhone.setLayoutY(340);
        trecieverPhone.setLayoutX(180);
        trecieverPhone.setLayoutY(340);
        
        amount.setLayoutX(80);
        amount.setLayoutY(380);
        tamount.setLayoutX(180);
        tamount.setLayoutY(380);
        
        b2.setLayoutX(80);
        b2.setLayoutY(440);
        
        clear.setLayoutX(160);
        clear.setLayoutY(440);
//        this.sendPane.getChildren().add(this.table2);
        this.sendPane.getChildren().add(this.lb3);
        this.sendPane.getChildren().add(this.b2);
        this.sendPane.getChildren().add(this.recieverPhone);
        this.sendPane.getChildren().add(this.trecieverPhone);
        this.sendPane.getChildren().add(this.amount);
        this.sendPane.getChildren().add(this.lbrecieve);
        this.sendPane.getChildren().add(this.tamount);
        //
        this.sendPane.getChildren().add(this.choice);
        this.sendPane.getChildren().add(this.choiceto);
        this.choice.getValue();
        this.sendPane.getChildren().add(this.lb);
        this.sendPane.getChildren().add(this.full_name);
        this.sendPane.getChildren().add(this.phone);
        this.sendPane.getChildren().add(this.clear);
        
        this.sendPane.getChildren().add(this.tfull_name);
        this.sendPane.getChildren().add(this.tphone);
        
        this.sendTab.setContent(this.sendPane);
        
    }

    private void initrecieveTab() {
        
        lb2.setLayoutX(40);
        lb2.setLayoutY(40);
        
        full_name2.setLayoutX(80);
        full_name2.setLayoutY(80);
        tfull_name2.setLayoutX(200);
        tfull_name2.setLayoutY(80);
        
        phone2.setLayoutX(80);
        phone2.setLayoutY(120);
        tphone2.setLayoutX(200);
        tphone2.setLayoutY(120);
    
        notice.setLayoutX(80);
        notice.setLayoutY(160);
        t1.setLayoutX(200);
        t1.setLayoutY(160);
            
        b3.setLayoutX(80);
        b3.setLayoutY(220);
        
        clear2.setLayoutX(160);
        clear2.setLayoutY(220);
        
        ta.setLayoutX(80);
        ta.setLayoutY(260);
        
            this.recievePane.getChildren().add(this.lb2);
            this.recievePane.getChildren().add(this.full_name2);
            this.recievePane.getChildren().add(this.phone2);
            
            this.recievePane.getChildren().add(this.tfull_name2);
            this.recievePane.getChildren().add(this.tphone2);
            this.recievePane.getChildren().add(this.clear2);
            
            this.recievePane.getChildren().add(this.notice);
            this.recievePane.getChildren().add(this.t1);
            this.recievePane.getChildren().add(this.b3);
            this.recievePane.getChildren().add(this.ta);
            this.recieveTab.setContent(this.recievePane);
    }

    private void initupdateTap() {
        this.updatingPane.getChildren().add(this.imformation);
        this.imformation.setLayoutX(40);
        this.imformation.setLayoutY(40);
        
        this.updatingPane.getChildren().add(this.enterCustomerID);
        this.enterCustomerID.setLayoutX(80);
        this.enterCustomerID.setLayoutY(80);
        
        this.updatingPane.getChildren().add(this.tenterCustomerID);
        this.tenterCustomerID.setLayoutX(220);
        this.tenterCustomerID.setLayoutY(80);
        
        this.updatingPane.getChildren().add(this.enterCustomerPhone);
        this.enterCustomerPhone.setLayoutX(80);
        this.enterCustomerPhone.setLayoutY(120);
        
        this.updatingPane.getChildren().add(this.tenterCustomerPhone);
        this.tenterCustomerPhone.setLayoutX(220);
        this.tenterCustomerPhone.setLayoutY(120);
        
        this.updatingPane.getChildren().add(this.update);
        this.update.setLayoutX(80);
        this.update.setLayoutY(160);
        
        this.updatingTab.setContent(this.updatingPane);
    }
    

}
