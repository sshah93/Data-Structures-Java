/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mypriorityqueue;

/**
 *
 * @author sshah75
 */
class Customer
    {
        public String name;
        public double income;
        public int    nrCars;
        public int    nrHouses;
        public int    coolness;
        public double priority;
        public int    schemeType;
        public int    profit;

        /*public double priority1;
        public double priority2;
        public double priority3;*/
        
        public Customer(int schemeType, int profit)
        {
            this.schemeType = schemeType;
            this.profit     = profit;
        }
        
        public Customer(String nam, double sal, int cars, int houses, int cool)
        {
            name     = nam;
            income   = sal;
            nrCars   = cars;
            nrHouses = houses;
            coolness = cool;
            priority = 0;
            
            /*priority0 = (1.5*income) + (25*nrCars) + (30*nrHouses) + (25*coolness);
            priority1 = (2*income) + (5*nrCars) + (60*nrHouses) + (30*coolness);
            priority2 = (income) + (15*nrCars) + (20*nrHouses) + (15*coolness); 
            priority3 = (2*income) + (5*nrCars) + (50*nrHouses) - (10*coolness);*/
        }
            
        public void setWeight(double pSal, int pCars, int pHouses, int pFactor)
        {
            priority = (pSal*income) + (pCars*nrCars) + (pHouses*nrHouses) + (pFactor*coolness);
        }
        
        public void setWeight0()
        {
            priority = (1.5*income) + (25*nrCars) + (30*nrHouses) + (25*coolness);
        }
        
        public void setWeight1()
        {
            priority = (2*income) + (5*nrCars) + (60*nrHouses) + (30*coolness);
        }
        
        public void setWeight2()
        {
            priority = (income) + (15*nrCars) + (20*nrHouses) + (15*coolness);
        }
        
        public void setWeight3()
        {
            priority = (2*income) + (5*nrCars) + (50*nrHouses) - (10*coolness);
        }
        
        public int getType()
        {
            return schemeType;
        }
    }