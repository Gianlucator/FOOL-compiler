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
push 13
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
push 3
lfp
push aA
js
print
halt

aA:
cfp
lra
push 1
lfp
add
lw
push -3
lop
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js
