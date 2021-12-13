// Jimmy Pasehke	L0002B

using System;


namespace Lab3
{
    public class Person
    {
        public String FName { get; private set; }       // Private set eftersom det initieras med klassen
        public String SName { get; private set; }
        public String Pnr { get; private set; }

        private int num = 5;

        public void Deposit(int amount) => num += amount;


        public Person(String fName, String sName, String pnr)
        {     // Konstruktor            
            this.FName = fName;
            this.SName = sName;
            if (pnr[6].Equals('-'))
            {    // Tar bort - innan födelsenumren ifall det är med, för att lättare hantera personnommer
                pnr = pnr.Substring(0, 6) + pnr.Substring(7);
            }
            this.Pnr = pnr;
        }
    
        public Boolean pnrCheck()
        {
            int tmp, result = 0;
            for (int i = 0; i < this.Pnr.Length; i++)
            {
                tmp = (int)Char.GetNumericValue(this.Pnr[i]);
                if (i % 2 == 0)
                {                                   // Om det är jämnt tal
                    tmp *= 2;                                       // Gånger två
                    if (tmp > 9)
                    {
                        tmp %= 10;                                           // Splittar och adderar båda om det är över 10
                        result += 1;                                         // Eftersom 12 är 1+2 och inte +12                     
                        result += tmp;
                    }
                    else
                    {
                        result += tmp;
                    }
                }
                else
                {
                    result += tmp;             // Ojämnt plussas bara på
                }
            }

            if (result % 10 == 0)
            {     // Ska gå jämnt ut med tio för att vara korrekt
                return true;
            }
            else
            {
                return false;
            }
        }


        /**
         * 
         * Returnerar "Man" eller "Kvinna" beroende på personnummer
         */
        public String genderCheck()
        {
            int result = (int)Char.GetNumericValue(this.Pnr[8]);    // Plockar ut 9e siffran, eller tredje födelsenumret
            if (result % 2 == 1)
            {     // Udda för män
                return "Man";
            }
            else
            {                  // Jämn för kvinnor
                return "Kvinna";
            }
        }

    }



}
