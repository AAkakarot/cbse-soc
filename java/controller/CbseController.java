package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CbseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Controller
@RequestMapping("/cbse")
public class CbseController {

    @Autowired
    CbseService cbseService;


    private static Socket socket;


    @RequestMapping(value = "/receiveListOfStudents", method = RequestMethod.GET)
    @ResponseBody
    public void returnFile(@RequestParam String rollno, @RequestParam String name, @RequestParam String schoolId, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws Exception {

        String roll = httpServletRequest.getParameter("rollno");
        String nm = httpServletRequest.getParameter("name");
        String school = httpServletRequest.getParameter("schoolId");

        cbseService.saveDataWithRollno(roll, nm, school);

        String filestring = cbseService.stringRollno(rollno);
        /*
        String url = "http://localhost:8085/api/user/receiveCbseRollnoList?cbseList="+ filestring ;
        Connection.getConnection(url);*/


        PrintWriter out = httpServletResponse.getWriter();
        out.println(filestring);




        /*try{

             int port = 9999;
             ServerSocket serverSocket = new ServerSocket(port);


            //Reading the message from the client
            socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String number = br.readLine();
            System.out.println("Message received from client is "+number);



            //Sending the response back to the client.
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(filestring);
            System.out.println("Message sent to the client is "+filestring);
            bw.flush();

        }
        catch (Exception e) {
            e.printStackTrace();
        }


        finally {
            try{
            socket.close(); }
            catch(Exception e){}
        }*/
    }


}