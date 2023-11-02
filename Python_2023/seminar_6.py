print('Прогрессия')
print()

x = int(input('Введите первое число прогрессии: '))
d = int(input('Ведите разность: '))
a = x-d
n = int(input('Введите количество элементов прогрессии: '))

c = []

for i in range(n):
    a = a+d
    c.append(a)
print(c)

print()
print('Индексы в заданном диапозоне')
print()

arr = [5,6,1,1,1,2,7,8]
max_ = 10
min_ = 3
for i in range(len(arr)):
    if arr[i] > min_ and arr[i] <= max_:
        print(i, end=' ')

