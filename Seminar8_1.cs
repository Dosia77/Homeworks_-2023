using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar8_1
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static int[,] GetArray(int N, int M)
        {
            int[,] array = new int[N, M];
            Random rand = new Random();
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    array[i, j] = rand.Next(0, 10);
                }
            }
            return array;
        }
        static void Print(int[,] array, int N, int M)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    Console.Write(array[i, j] + " ");
                }
                Console.WriteLine();

            }
        }
        static int[,] SortArrRow(int[,] arr, int N, int M)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    for (int k = 0; k < M - 1; k++)
                    {
                        if (arr[i, k] < arr[i, k + 1])
                        {
                            int temp = arr[i, k + 1];
                            arr[i, k + 1] = arr[i, k];
                            arr[i, k] = temp;
                        }
                    }
                }
            }
            return arr;
        }

        static void Main(string[] args)
        {
            int n = Prompt("Введите количество рядов: ");
            int m = Prompt("Введите количество столбцов: ");
           
            int[,] arr = GetArray(n, m);
            Print(arr, n, m);
            SortArrRow(arr, n, m);
            Console.WriteLine("Результат сортировки по убыванию:");
            Print(arr, n, m);
            Console.ReadLine();
        }

    }
    }  
