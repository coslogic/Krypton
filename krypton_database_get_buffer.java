import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;

import java.security.MessageDigest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;




public class krypton_database_get_buffer{



    String[] token_ssp2 = new String[network.listing_size];


    int ix0 = 0;
    int ix1 = 0;
    int ix2 = 0;




    public String[] getToken(){//**************************************************************************
    network.database_in_use = 1;



        try{




                boolean found_item = false;
                String idx = new String();
                long add_time = (long) 100000;



                for(int loop1 = 0; loop1 < network.listing_size; loop1++){//***********

                    token_ssp2[loop1] = new String("error");

                }//********************************************************************




                System.out.println("Load unconfirmed_db..." );

                krypton_database_driver.s = krypton_database_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                krypton_database_driver.s.setMaxRows(1);
                krypton_database_driver.rs = krypton_database_driver.s.executeQuery("SELECT * FROM send_buffer ORDER BY xd ASC");

                ix0 = 0;
                while(krypton_database_driver.rs.next()){


                  for(int loop1 = 0; loop1 < network.listing_size; loop1++){//***********

                       token_ssp2[loop1] = new String(krypton_database_driver.rs.getString((loop1 + 2)));

                  }//********************************************************************

                found_item = true;

                }//while

                System.out.println("idx " + idx);




                krypton_database_driver.conn.commit();
                System.out.println("Committed the transaction");

        }catch(Exception e){e.printStackTrace();}


    network.database_in_use = 0;
    return token_ssp2;

    }//load




 
}//class
