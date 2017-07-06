push 0
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
push 1
lfp
push sB
js
print
halt

uA:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

sB:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js
