package lk.ijse.hostelmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.hostelmanagementsystem.dto.custom.StudentDTO;
import lk.ijse.hostelmanagementsystem.service.custom.StudentService;
import lk.ijse.hostelmanagementsystem.service.custom.impl.StudentServiceImpl;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudentFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXButton btnSaveStudents;
    public JFXTextField txtGmail;
    public JFXTextField txtCity;
    public JFXButton btnClear;

    private StudentService studentService;

    public void initialize(){
        studentService =new StudentServiceImpl();
     }

    public StudentDTO collectData(){
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String contact = txtContactNo.getText();
        String gmail = txtGmail.getText();

        StudentDTO student =new StudentDTO(id,name,address,city,contact,gmail,null);
        return student;
    }

    public void btnSaveStudentsOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO =collectData();
        StudentDTO save =studentService.save(studentDTO);
        if (save!=null){
            new Alert(Alert.AlertType.INFORMATION,"Student Added Success").show();

        }else {
            new Alert(Alert.AlertType.INFORMATION,"Student Added Failed").show();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtCity.clear();
        txtContactNo.clear();
        txtGmail.clear();
    }



    public void txtNameOnAction(javafx.scene.input.KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$");
        Matcher m1=p1.matcher(txtName.getText());
        boolean b=m1.find();
        if (b){
            txtName.setUnFocusColor(javafx.scene.paint.Paint.valueOf("#2ecc71"));
        }else{
            txtName.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }

    public void txtCityOnAction(javafx.scene.input.KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^([ \\u00c0-\\u01ffa-zA-Z'\\-])+$");
        Matcher m1=p1.matcher(txtCity.getText());
        boolean b=m1.find();
        if (b){
            txtCity.setUnFocusColor(javafx.scene.paint.Paint.valueOf("#2ecc71"));
        }else{
            txtCity.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }

    public void txtContactOnAction(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$");
        Matcher m1=p1.matcher(txtContactNo.getText());
        boolean b=m1.find();
        if (b){
            txtContactNo.setUnFocusColor(javafx.scene.paint.Paint.valueOf("#2ecc71"));
        }else{
            txtContactNo.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }
}
