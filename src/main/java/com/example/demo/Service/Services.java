package com.example.demo.Service;


import com.example.demo.Model.*;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Repository.LoginRepo;
import com.example.demo.Repository.NewsFeedRepo;
import com.example.demo.Repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Services {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    NewsFeedRepo newsFeedRepo;
    @Autowired
    ScheduleRepo scheduleRepo;
    @Autowired
    LoginRepo loginRepo;

    public List<Customer> getAll(){
        return customerRepo.getAll();
    }

    public List<Owner> getAllEmployees(){
        return userRepo.getAllEmployees();
    }

    public List<NewsFeed> getAllNewsFeed(){
        return newsFeedRepo.getAllNewsFeed();
    }

    public Customer addCustomer (Customer c){
        return customerRepo.addCustomer(c);
    }

    public Boolean deleteNewsFeed(int id){
        return newsFeedRepo.deleteNewsFeed(id);
    }

    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    public NewsFeed createNewsFeed(NewsFeed newsFeed){
        return newsFeedRepo.createNewsFeed(newsFeed);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepo.getAllSchedules();
    }

    public List<Schedule> getFirstSchedule(){
        return scheduleRepo.getFirstSchedule();
    }

    public List<Schedule> getOneSchedule(String date){
        return scheduleRepo.getOneSchedule(date);
    }

    public Schedule createSchedule(Schedule s){
        return scheduleRepo.createSchedule(s);
    }

    public List<Schedule> getInfoToSchedule(String select, String from, String where, String firstCondition){
        return scheduleRepo.getInfoToSchedule(select, from, where, firstCondition);
    }

    public List<Schedule> getInfoToSchedule(String select, String from, String where, String firstCondition, String and, String secondCondition){
        return scheduleRepo.getInfoToSchedule(select, from, where, firstCondition, and, secondCondition);
    }

    public double getHoursWorked() {
        //TODO
        int hour1 = 7;
        int min1 = 30;
        int hour2 = 15;
        int min2 = 0;
        double total = 0;

        if(hour2 > hour1){
            total = hour2 - hour1;
        }
        else if(hour2 < hour1) {
            hour2 += 24;
            total = hour2 - hour1;
        }
        if(min1 == 30 && min2 == 30){
            total = total;
        }
        else if(min1 == 30 || min2 == 30) {
            total -= 0.5;
        }
        return 2.0;
    }

    public Owner addEmployee(Owner o){
        return userRepo.addEmployee(o);
    }

    public List<Login> getLogin(){
        return loginRepo.getLogin();
    }
    public Customer updateCustomer(int id, Customer c){
        return customerRepo.updateCustomer(id, c);
    }
    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);

    }

    public Owner updateEmployee(int id, Owner o){
        return userRepo.updateEmployee(id, o);
    }

    public Owner findEmployeeById(int id) {
        return userRepo.findEmployeeById(id);
    }


    public Boolean deleteEmployee(int id){
        return userRepo.deleteEmployee(id);
    }






}

