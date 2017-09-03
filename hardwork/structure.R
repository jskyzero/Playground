# structure
flag <- TRUE

# check whether there is flag in ls()
have_flag <- deparse(substitute(flag)) %in% ls()

if (exists(deparse(substitute(flag)))) {
  print("find flag")
} else {
  for ( obj in ls() ) {
      cat("---", obj, "---\n")
      print(get(obj))
  }
}
