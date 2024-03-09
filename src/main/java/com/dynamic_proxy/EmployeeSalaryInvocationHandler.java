package com.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employee;

    public EmployeeSalaryInvocationHandler(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //pre processing
        if(method.getName().equals("giveHike")) {
            double hikeAmount = (double) args[0];
            if(hikeAmount > 1000) {
                throw new IllegalArgumentException("Hike amount cannot be more than 1000");
            }
        }

        Object returnValue = method.invoke(employee, args);

        //post processing
        return returnValue;
    }
}
