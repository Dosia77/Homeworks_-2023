using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar2_2
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Задача 10");
            Console.Write("Введи трёхзначное число: ");
            string number = Console.ReadLine();
            Console.WriteLine("вторая цифра числа: " + number[1]);
            Console.ReadLine();
            Console.WriteLine("Задача  13");
            
           Console.Write("Введи число: ");
            string number1 = Console.ReadLine();
            if (number1.Length > 2)
            {
                Console.WriteLine("третья цифра числа: " + number1[2]);
            }
            else
            {
                Console.WriteLine("в числе нет третьей цифры.");
            }
                Console.ReadLine();
                Console.WriteLine("Задача 15");

                Console.Write("Введи номер дня недели от 1 до 7-ми: ");
                int Number = Convert.ToInt32(Console.ReadLine());
            

                if (Number == 6 || Number == 7)
                {
                    Console.WriteLine("Да");
                }
                else if (Number < 1 || Number > 7)
                {
                    Console.WriteLine("Ввод не корректен!");
                }
                else
                {
                    Console.WriteLine(" Нет"); 
                }
                Console.ReadLine();
            }
    }
}
