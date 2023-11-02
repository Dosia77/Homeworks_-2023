using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar8_3
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static int[,] GetArray(int n, int m)
        {
            int[,] array = new int[n, m];
            Random rand = new Random();
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    array[i, j] = rand.Next(0, 10);
                }
            }
            return array;
        }

        static void PrintArray(int[,] array, int n, int m)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write(array[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
        static int[,] MultyArray(int[,] firstArray, int[,] secomdArray, int rowA, int columnB, int columnA)
        {
            int[,] thirdArray = new int[rowA, columnB];
            for (int i = 0; i < rowA; i++)
            {
                for (int j = 0; j < columnB; j++)
                {
                    thirdArray[i, j] = 0;
                    for (int k = 0; k < columnA; k++)
                    {
                        thirdArray[i, j] = thirdArray[i, j] + (firstArray[i, k] * secomdArray[k, j]);
                    }

                }

            }
            return thirdArray;
        }
        static void Main()
        {
            int rowA = Prompt("Введите количество рядов: ");
            int columnA = Prompt("Введите количество столбцов: ");
            int rowB = columnA;
            int columnB = Prompt("Введите количество столбцов: ");

            int[,] arrA = GetArray(rowA, columnA);
            int[,] arrB = GetArray(rowB, columnB);
            PrintArray(arrA, rowA, columnA);
            Console.WriteLine();
            PrintArray(arrB, rowB, columnB);
            Console.WriteLine("Перемноженные матрицы:");
            int[,] arrC = MultyArray(arrA, arrB, rowA, columnB, columnA);
            PrintArray(arrC, rowA, columnB);
            Console.ReadLine();
        }

    }
}
