import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author brent
 */
public class AdminPage extends javax.swing.JFrame {

    public AdminPage() {
        initComponents();
        try{
            Connection();
            Function();
            if (Connection != null) {
                JOptionPane.showMessageDialog(null, "Welcome Admin");
            }
        } catch(SQLException ex){
            
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    private int getIdForUpdate(String username, String name, String password, String contactNumber) {
        int id = -1; 
        
        try {
            String selectQuery = "SELECT id FROM sampledatabase WHERE Username=? OR Name=? OR Password=? OR ContactNumber=?";
            PreparedStatement pstmt = Connection.prepareStatement(selectQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setString(4, contactNumber);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    Connection Connection;
    
    Statement Statement;
    
    private static final String DbName = "enzodatabase";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/" + DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";
    
    
    
    public void Connection() throws SQLException{
        
        try {
            Class.forName(DbDriver);
            Connection = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            Statement = Connection.createStatement();
            if (Connection != null) {
                JOptionPane.showMessageDialog(null, "Welcome to Admin Page");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    private int sampledatabase(String username, String name, String password, String contactNumber) {
        int id = -1; 
        
        try {
            String selectQuery = "SELECT id FROM accountable WHERE Username=? OR Name=? OR Password=? OR ContactNumber=?";
            PreparedStatement pstmt = Connection.prepareStatement(selectQuery);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setString(4, contactNumber);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
     
    
    
    public void Function(){
        PreparedStatement pst;
        
        try {
            
            pst = Connection.prepareStatement("SELECT * FROM sampledatabase");
            
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int columnCount = rsmd.getColumnCount();
            
            DefaultTableModel tableModel = (DefaultTableModel) Table.getModel();
            tableModel.setRowCount(0);
            
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 2; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    
                    if (value instanceof Number) {
                        rowData.add(value);
                    } else {
                        
                        rowData.add(value.toString());
                    }
                }
                tableModel.addRow(rowData);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SignoutButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddNewButton = new javax.swing.JToggleButton();
        ClearButton = new javax.swing.JToggleButton();
        UpdateButton = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        NameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        LocationField = new javax.swing.JTextField();
        ContactNumberField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        SignoutButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignoutButton.setText("Signout");
        SignoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignoutButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        AddNewButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AddNewButton.setText("ADD");
        AddNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ClearButton.setText("CLEAR");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SignoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addGap(120, 120, 120))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 435, 893, 80));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Admin ");

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel7)))
                .addContainerGap(476, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 86));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Password", "Location", "Contact#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 290));

        NameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameField.setForeground(new java.awt.Color(102, 102, 102));
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(NameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 27, 268, 40));

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("UserName");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 73, -1, -1));

        UsernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UsernameField.setForeground(new java.awt.Color(102, 102, 102));
        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(UsernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 99, 268, 40));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 6, 98, -1));

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 145, -1, -1));

        PasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(102, 102, 102));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 171, 268, 40));

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Location:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        LocationField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LocationField.setForeground(new java.awt.Color(102, 102, 102));
        LocationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationFieldActionPerformed(evt);
            }
        });
        jPanel1.add(LocationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 270, 40));

        ContactNumberField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContactNumberField.setForeground(new java.awt.Color(102, 102, 102));
        ContactNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactNumberFieldActionPerformed(evt);
            }
        });
        jPanel1.add(ContactNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 270, 40));

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Contact Number#");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 86, 790, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutButtonActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_SignoutButtonActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LocationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationFieldActionPerformed

    private void ContactNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactNumberFieldActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
      DefaultTableModel table = (DefaultTableModel) Table.getModel();
        int selectedRow = Table.getSelectedRow();
        
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            return;
        }
        
        String name = NameField.getText();
        String username = UsernameField.getText();
        
        PreparedStatement pst;
        
        try {
            
            String rowName = table.getValueAt(selectedRow, 0).toString();
            String rowUsername = table.getValueAt(selectedRow, 2).toString();
            
            
            int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm to delete", "Warning", JOptionPane.YES_NO_OPTION);
            
            if (deleteItem == JOptionPane.YES_OPTION) {
                
                pst = Connection.prepareStatement("DELETE FROM sampledatabase WHERE Name = ? AND Username = ?");
                pst.setString(1, name);
                pst.setString(2, username);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    
                    table.removeRow(selectedRow);
                    
                    
                    for (int i = selectedRow; i < table.getRowCount(); i++) {
                        table.setValueAt(i + 1, i, 0);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Record has been deleted");
                    Function();
                    
                    
                    NameField.setText("");
                    NameField.requestFocus();
                    UsernameField.setText("");
                    PasswordField.setText("");
                    ContactNumberField.setText("");
                    LocationField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No record found with the specified Name and Username.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for row number.");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewButtonActionPerformed
        PreparedStatement pst;

        String name = NameField.getText();
        String username = UsernameField.getText();
        String password = PasswordField.getText();
        String ContactNumber = ContactNumberField.getText();
        String Address = LocationField.getText();
        String regex1 = "^09[0-9]{9}$";
        String regex2 = "^[a-zA-Z]+$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcherContactNumber = pattern1.matcher(ContactNumber);
        Matcher matcherName = pattern2.matcher(name);

        if(name.equals("")||username.equals("")||password.equals("")||ContactNumber.equals("")||Address.equals("")){
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){
            JOptionPane.showMessageDialog(null, "Invalid name. Name should contain only alphabet characters");
        }else if(!matcherContactNumber.matches()){

            JOptionPane.showMessageDialog(null, "Phone number is Invalid. Enter a valid Number format - PH number");

        }else{

            try{
                int Add = JOptionPane.showConfirmDialog(null, "Confirm to Add Data", "Warning", JOptionPane.YES_NO_OPTION);

                if (Add == JOptionPane.YES_OPTION) {

                    pst = Connection.prepareStatement("insert into accountable(Name,Username,Password,ContactNumber,Address)value(?,?,?,?,?)");

                    pst.setString(1, NameField.getText());
                    pst.setString(2, UsernameField.getText());
                    pst.setString(3, PasswordField.getText());
                    pst.setString(4, ContactNumberField.getText());
                    pst.setString(5, LocationField.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added");
                    Function();

                    NameField.setText("");
                    NameField.requestFocus();
                    UsernameField.setText("");
                    PasswordField.setText("");
                    ContactNumberField.setText("");
                    LocationField.setText("");

                }
            }catch(SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_AddNewButtonActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        DefaultTableModel table = (DefaultTableModel)Table.getModel();
        int selectedRows = Table.getSelectedRow();
        
        NameField.setText(table.getValueAt(selectedRows, 0).toString());
        UsernameField.setText(table.getValueAt(selectedRows, 1).toString());
        PasswordField.setText(table.getValueAt(selectedRows, 2).toString());
        ContactNumberField.setText(table.getValueAt(selectedRows, 3).toString());
        LocationField.setText(table.getValueAt(selectedRows, 4).toString());
        Table.isEditing();
    }//GEN-LAST:event_TableMouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

        int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm to Clear text Fields", "Warning", JOptionPane.YES_NO_OPTION);

        if (deleteItem == JOptionPane.YES_OPTION) {

            NameField.setText("");
            UsernameField.setText("");
            PasswordField.setText("");
            ContactNumberField.setText("");
            LocationField.setText("");

            JOptionPane.showMessageDialog(null, "Successfully cleared");

        }

    }//GEN-LAST:event_ClearButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed

        PreparedStatement pst;

        String name = NameField.getText();
        String username = UsernameField.getText();
        String password = PasswordField.getText();
        String contactNumber = ContactNumberField.getText();
        String address = LocationField.getText();
        String regex1 = "^09[0-9]{9}$";
        String regex2 = "^[a-zA-Z]+$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcherContactNumber = pattern1.matcher(contactNumber);
        Matcher matcherName = pattern2.matcher(name);

        if (name.equals("") || username.equals("") || password.equals("") || contactNumber.equals("") || address.equals("")) {
            JOptionPane.showMessageDialog(null, "Make sure to fill out the empty textfield");
        }else if(!matcherName.matches()){
            JOptionPane.showMessageDialog(null, "Invalid name. Name should contain only alphabet characters");
        } else if (!matcherContactNumber.matches()) {
            JOptionPane.showMessageDialog(null, "Phone number is Invalid. Enter a valid Number format - PH number");

        } else {

            try{

                int Update = JOptionPane.showConfirmDialog(null, "Confirm to Update", "Warning", JOptionPane.YES_NO_OPTION);

                if (Update == JOptionPane.YES_OPTION) {

                    int id = getIdForUpdate(username,name,password,contactNumber);
                    String updateQuery = "UPDATE sampledatabase SET Username=?, Password=?, ContactNumber=?, Location=?, Name=? WHERE id=?";
                    pst = Connection.prepareStatement(updateQuery);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    pst.setString(3, contactNumber);
                    pst.setString(4, address);
                    pst.setString(5, name);
                    pst.setInt(6, id);

                    int rowsAffected = pst.executeUpdate();
                    Function();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "No details to update");
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error occurred while updating. Please try again later.");
            }

        }
    }//GEN-LAST:event_UpdateButtonActionPerformed
 
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AddNewButton;
    private javax.swing.JToggleButton ClearButton;
    private javax.swing.JTextField ContactNumberField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField LocationField;
    private javax.swing.JTextField NameField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SignoutButton;
    private javax.swing.JTable Table;
    private javax.swing.JToggleButton UpdateButton;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


}
