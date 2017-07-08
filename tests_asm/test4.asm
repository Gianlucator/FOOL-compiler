push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
push 1
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
push -3
lfp
add
lw
lfp
push aparamB61
js
print
halt

aparamB61:
cfp
lra
push 1
lfp
add
lw
sop
lfp
lfp
push bA11
js
srv
sra
pop
pop
sfp
lrv
lra
js

bA11:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js
