using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Exercise_4
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Введите число больше единицы: ");
            int a = int.Parse(Console.ReadLine());


            int i = 0;
            while (i < a)
            {
                i++;
                if (i % 2 == 0)
                {

                    Console.Write(i + " ");

                }
            }


            Console.ReadLine();
        }
    }
}
