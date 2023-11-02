using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar8_4
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static void PrintArray(int[,,] arr, int a, int b, int c)
        {

            for (int i = 0; i < a; i++)
            {
                for (int j = 0; j < b; j++)
                {

                    for (int k = 0; k < c; k++)
                    {
                        Console.Write($"({i},{j},{k})={arr[i, j, k]}; ");

                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }
        static int[,,] GetArray(int a, int b, int c)
        {
            int[,,] array = new int[a, b, c];
            int[] values = new int[a * b * c];
            int numberV = 0;
            for (int i = 0; i < (a * b * c); i++)
            {
                values[i] = new Random().Next(-10, 100);
                numberV = values[i];
                if (i >= 1)
                {
                    for (int j = 0; j < i; j++)
                    {
                        while (values[i] == values[j])
                        {
                            values[i] = new Random().Next(-10, 100);
                            j = 0;
                            numberV = values[i];
                        }
                        numberV = values[i];
                    }
                }
            }
            int number = 0;
            for (int x = 0; x < a; x++)
            {
                for (int y = 0; y < b; y++)
                {
                    for (int z = 0; z < c; z++)
                    {
                        array[x, y, z] = values[number];
                        number++;
                    }
                }
            }
            return array;
        }
        static void PrintArray2(int[,,] arr, int a, int b, int c)
        {

            for (int i = 0; i < a; i++)
            {
                for (int j = 0; j < b; j++)
                {

                    for (int k = 0; k < c; k++)
                    {
                        Console.Write($"{arr[i, j, k]} ");

                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
        }
        static void Main()
        {
            int x = Prompt("Введите измерение Х: ");
            int y = Prompt("Введите измерение Y: ");
            int z = Prompt("Введите измерение Z: ");
           
            int[,,] arrayThree = GetArray(x, y, z); ;

            Console.WriteLine("Элементы с индексами:");
            PrintArray(arrayThree, x, y, z);
            Console.WriteLine("Трёхмерный массив: ");
            PrintArray2(arrayThree, x, y, z);
            Console.ReadLine();
        }

    }
}
