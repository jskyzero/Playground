# install.packages("fun")
# from https://www.rdocumentation.org/packages/fun/versions/0.1-0
library("fun")

## should use Xlib for the x11() device under *nix, e.g
## Not run: 
# if (.Platform$OS.type == "windows") 
#     x11() else x11(type = "Xlib")
# ## End(Not run)

mine_sweeper()