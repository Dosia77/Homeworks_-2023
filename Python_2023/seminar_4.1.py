
print('Совпадающие числа в двух множествах')
print()
n = int(input('введите количество элементов первого списка: '))
lst_1 = map(int, input(f'введите {n} элементов первого списка через пробел: ').split())

m = int(input('введите количество элементов второго списка: '))
lst_2 = map(int, input(f'введите {m} элементов второго списка через пробел: ').split())

lst_3 = list(set(lst_1) & set(lst_2))
lst_3.sort()
print(lst_3)

print()
print('Сбор черники')
print()

n = int(input('введите количество кустов: '))
bush = []
for i in range(n):
    berr = int(input(f'введите количество ягод на {i+1} кусте: '))
    bush.append(berr)
print(bush)

bush.extend([bush[0], bush[1]])
lst = []
for i in range(len(bush)):
    bush[i] = bush[i:i+3]
    lst.append(sum(bush[i]))
print(f'Максимальный сбор ягод за один заход: {max(lst)}')


