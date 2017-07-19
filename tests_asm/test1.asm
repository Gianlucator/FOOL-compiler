push 0
push function0
lfp
push 1
push 5
lfp
push -2
lfp
add
lw
js
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 1
lfp
add
lw
lfp
push 2
lfp
add
lw
push 1
lfp
add
lw
push 1
add
lfp
lw
push -2
lfp
lw
add
lw
js
mult
b label1
label0:
push 2
lfp
add
lw
label1:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
