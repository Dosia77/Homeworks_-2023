using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Task_2
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Введите первое число: ");
            int number_1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Введите второе число: ");
            int number_2 = int.Parse(Console.ReadLine());
            int max = 0;
            if (number_1 > number_2)
            {
                max = number_1;
            }
            else
            {
                max = number_2;
            }
            Console.WriteLine("max = " + max);
            Console.ReadLine();



        }
    }
}
