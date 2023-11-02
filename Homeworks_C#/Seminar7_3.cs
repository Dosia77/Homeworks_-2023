using System;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar7_3
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static int[,] GetArray(int N, int M, int minV, int maxV)
        {
            int[,] array = new int[N, M];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    array[i, j] = new Random().Next(minV, maxV);

                }
            }
            return array;
        }
        static void PrintArray(int[,] array, int N, int M)

        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    Console.Write("{0,4}", array[i, j]);
                }
                Console.WriteLine();
            }
        }
        static void Average(int [,] arr, int N, int M)
        {
            double sum = 0;
            double[] S = new double[M];
            
            for (int i = 0; i < M; i++)

            {
                S[i] = 0;
                for (int j = 0; j < N; j++)
                {
                    S[i] = (S[i] + arr[j, i]); sum =  S[i]/N; 
                    
                }
                Console.WriteLine($"Среднее арифметическое столбец {i+1}: {sum}") ;
            }

        }
        static void Main(string[] args)
        {
            int row = Prompt("Введите количество рядов: ");
            int column = Prompt("Введите количество столбцов: ");
            int minValue = Prompt("Введите минимальное значение: ");
            int maxValue = Prompt("Введите максимальное значение: ");

            int[,] a = GetArray(row, column, minValue, maxValue);

            PrintArray(a, row, column);
            Average(a, row, column);
            Console.ReadLine();
    }
    }
}
