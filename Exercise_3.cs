using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Exercise_3

    {
        static void Main(string[] args)
        {
            Console.WriteLine("Введите число: ");
            int number = int.Parse(Console.ReadLine());
            if (number % 2 == 0)
                Console.WriteLine("Да");
            else
                Console.WriteLine("Нет");
            Console.ReadLine();
        }
    }
}
