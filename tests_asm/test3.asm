push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 2
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
push 3
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
push aparamB
js
print
halt

aparamB:
cfp
lra
push 1
lfp
add
lw
sop
lfp
lfp
push bA
js
srv
sra
pop
pop
sfp
lrv
lra
js

bA:
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
