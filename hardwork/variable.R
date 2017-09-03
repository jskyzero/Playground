# variables in R

# Valid names should consist of letters, numbers, and '_' '.' 
# starts with a letter, or the dot not followed by a number.

today.weather <- "sun"
"2017/09/03"  -> today.date

cat ("about today\n",
     "\bdate is ", today.date, "\n",
     "\bweather is ", today.weather, "\n")

# find / letele variables
print(ls(all.names = TRUE))
rm(today.weather)
print(ls(all.names = TRUE))
