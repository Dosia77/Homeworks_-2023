import pandas as pd
import random
lst = ['robot'] * 10
lst += ['human'] * 10

random.shuffle(lst)

data = pd.DataFrame({'whoAmI':lst})
print(data.head())

data_values = {"whoAmI":  {"human": 1, "robot": 0}}
one_hot_data = data.replace(data_values)

print(one_hot_data.head())