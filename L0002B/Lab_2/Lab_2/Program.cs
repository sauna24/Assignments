// Jimmy Pasehke L0002B

using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Lab2
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Person> personList = new List<Person>(); // Lista med Person där säljare sparas
            String tmp, s49 = "", s99 = "", s199 = "", s200 = "", result, UserInput;
            int counter49 = 0, counter99 = 0, counter199 = 0, counter200 = 0, sellerCount = 0;
            Person tmpP;


            Console.WriteLine("Ange antal säljare: ");  //Ber användaren mata in antalet säljare
            UserInput = Console.ReadLine();
            sellerCount = Convert.ToInt32(UserInput);

            while (true)
            {      // Loopar till det är antalet säljare som angetts
                Console.Write("\nAnge namn: ");
                tmp = getInput();
                tmpP = new Person(tmp);

                Console.Write("Ange personnummer: ");
                tmp = getInput();
                tmpP.Persnr = tmp;

                Console.Write("Ange distrikt: ");
                tmp = getInput();
                tmpP.Distrikt = tmp;

                Console.Write("Ange antal sålda: ");
                int tmpInt = Convert.ToInt32(getInput()); // Sparar antal sålda som integer så det går att jämföra lättare
                tmpP.AntalS = tmpInt;

                personList.Add(tmpP);

                if (personList.Count == sellerCount)
                {    // Bryter loopen när antalet säljare som angetts är nått
                    break;
                }
            }

            //Sortera lista
            personList.Sort((x, y) => x.AntalS.CompareTo(y.AntalS)); // Sorterar från minsta till största genom att använda sig av get-metoden för AntalS           

            //Dela in i fyra olika strängar
            for (int i = 0; i < personList.Count; i++)
            {    // Loopar igenom hela listan
                tmpP = personList[i];       // Plockar ut pekare till den aktuella säljaren
                if (tmpP.AntalS <= 49)
                {        // Bestämmer kategori för säljaren samt inkrementerar räknaren för kategorin
                    counter49++;
                    s49 += printPerson(tmpP);
                }
                else if (tmpP.AntalS <= 99)
                {
                    counter99++;
                    s99 += printPerson(tmpP);
                }
                else if (tmpP.AntalS <= 199)
                {
                    counter199++;
                    s199 += printPerson(tmpP);
                }
                else if (tmpP.AntalS >= 200)
                {
                    counter200++;
                    s200 += printPerson(tmpP);
                }
            }

            if (counter49 > 0)
            {                        // Lägger till text för antalet säljare i varja kategori
                s49 += String.Format("{0} säljare har nått nivå 1: 0-49 artiklar\n\n", counter49);
            }
            if (counter99 > 0)
            {
                s99 += String.Format("{0} säljare har nått nivå 2: 50-99 artiklar\n\n", counter99);
            }
            if (counter199 > 0)
            {
                s199 += String.Format("{0} säljare har nått nivå 3: 100-199 artiklar\n\n", counter199);
            }
            if (counter200 > 0)
            {
                s200 += String.Format("{0} säljare har nått nivå 4: 200+ artiklar\n\n", counter200);
            }

            // Skapar den slutgiltiga strängen för resultatet. 
            result = String.Format("{0,-15}{1,-15}{2,-15}{3,-15}\n{4}{5}{6}{7}", "Namn", "Personnummer", "Distrikt", "Antal", s49, s99, s199, s200);

            String path = @"..\..\..\Resultat.rtf"; // Skriver till mappen där Lab2-mappen finns      
            System.IO.File.WriteAllText(path, result);

            Console.WriteLine(result);  // Printar resultatet
        }


        public static String getInput()
        {       // Liten metod som returnerar input, slipper kodupprepning tack vare denna
            return Console.ReadLine();
        }

        public static String printPerson(Person p)
        {    // Samam som ovan. Denna metod returnerar datan från Personen        
            return String.Format("{0,-15}{1,-15}{2,-15}{3,-15}\n", p.Name, p.Persnr, p.Distrikt, p.AntalS.ToString());
        }

    }

    class Person
    {  // Person-klass för listan
        public String Name { get; private set; }
        public String Persnr { get; set; }
        public String Distrikt { get; set; }
        public int AntalS { get; set; }

        public Person(String name)
        {
            this.Name = name;
        }

    }
}