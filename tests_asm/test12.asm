push 0
push 5
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
push 10
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
push 11
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

afunA:
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

aparamB:
cfp
lra
push -3
lop
add
lw
push 1
lfp
add
lw
sop
lfp
lfp
push afunA
js
mult
srv
sra
pop
pop
sfp
lrv
lra
js
