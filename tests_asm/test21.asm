push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 24
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
lfp
push getB
js
print
halt

getB:
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
