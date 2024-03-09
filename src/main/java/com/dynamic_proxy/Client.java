package com.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IEmployee employee = new ITEmployee();
        employee.setId(1);
        employee.setName("John");
        employee.setSalary(1000);
        employee.giveHike(500);
        System.out.println(employee.getSalary());

        EmployeeSalaryInvocationHandler employeeSalaryInvocationHandler =
                new EmployeeSalaryInvocationHandler(employee);

        IEmployee employeeProxy = (IEmployee) Proxy.newProxyInstance(
                employee.getClass().getClassLoader(),
                employee.getClass().getInterfaces(),
                employeeSalaryInvocationHandler
        );

        employeeProxy.giveHike(5000);
        System.out.println(employeeProxy.getSalary());


    }
}
