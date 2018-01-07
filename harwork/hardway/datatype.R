# Data type in R

# basic data type
v <- 2L
print(class(v));
v <- 12.3;
print(class(v));
v <- TRUE;
print(class(v));
v <- "hello"
print(class(v));
v <- charToRaw("hello")
print(class(v));

# use basic to construct high-level

# vector
colors <- c("red", "green", "yello")
print(colors)
print(class(colors))

# list
document <- list(colors, "my colors")
print(document)
print(class(document))

# matrix
matrix <- matrix(c(11, 12, 21, 22), nrow = 2, ncol = 2, byrow = TRUE)
print(matrix)

# array 
array <- array(c("green", "yellow"), dim = c(3, 3, 2))
print(array)

# factor
# frame