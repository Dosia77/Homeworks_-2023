using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar5_1
    {
        static int Request(string message)
        {
            Console.Write(message);
            int result = int.Parse(Console.ReadLine());
            return result;

        }
        static void PrintArray(int [] array)
        {
            Console.Write("[");
            for(int i=0; i<array.Length-1; i++)
            {
                Console.Write($"{array[i]}, ");
            }
            Console.Write($"{array[array.Length-1]}");
            Console.WriteLine("]");
        }
        static void CountEven(int[] mas)
        {
            int count = 0;  
            for (int i = 0; i <mas.Length; i++)
            {               
                if (mas[i] % 2 == 0) count++;

            }
            Console.Write("Количество чётных чисел в массиве: {0} ", count);

            Console.ReadLine();
        }
       
        static int [] IntArray(int length, int min,int max)
        {
            int[] mas = new int [length]; 
            Random r = new Random();
            for (int i = 0; i <length; i++)
            {
                mas[i] = r.Next(min,max);

            }
            return mas;
        }
        
            static void Main(string[] args)
            {

            // задача # 34

            int length = Request("Задайте длину массива: ");
            int min = Request("Начальное трёхзначное число для диапозона массива случайных чисел: ");
            int max = Request("Конечное трёхзначное число для диапозона массива случайных чисел: ");
            int[] array = IntArray(length, min, max);

            
            PrintArray(array);
            CountEven(array);

            Console.ReadLine();
        }    }
}
