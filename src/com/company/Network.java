package com.company;


import java.util.Arrays;

public class Network {

    private double[][]outputs;
    private double[][][] weights;
    private double[][]bias;
    private double[][]errorsignal;
    private double[][]outputderivative;

    public final int[] layerSize;
    public final int inputSize;
    public final int networkSize;
    public final int outputSize;

    public Network(int...layerSize)
    {
        this.layerSize=layerSize;
        this.inputSize=layerSize[0];
        this.networkSize=layerSize.length;
        this.outputSize=layerSize[networkSize-1];

        this.outputs=new double[networkSize][];
        this.errorsignal=new double[networkSize][];
        this.outputderivative=new double[networkSize][];
        this.weights=new double[networkSize][][];
        this.bias=new double[networkSize][];

        for(int i=0;i<networkSize;i++)
        {
            this.outputs[i]= new double[layerSize[i]];
            this.errorsignal[i]= new double[layerSize[i]];
            this.outputderivative[i]= new double[layerSize[i]];
            this.bias[i]= NetworkTools.createRandomArray(layerSize[i],-0.5,0.5);
            if(i>0) this.weights[i]=NetworkTools.createRandomArray(layerSize[i],layerSize[i-1],-0.5,0.5);
        }
    }

    private double[] calculate(double...input)
    {
        //if(this.inputSize!=input.length) return null;
        this.outputs[0]=input;
        for(int layer=1; layer<networkSize; layer++)
        {
            for(int neuron=0; neuron<layerSize[layer]; neuron++)
            {
                double sum=bias[layer][neuron];
                {
                    for(int prevneuron =0;prevneuron<layerSize[layer-1];prevneuron++)
                    {
                        sum+=outputs[layer-1][prevneuron]*weights[layer][neuron][prevneuron];
                    }
                }
                outputs[layer][neuron]=1d/(1+Math.exp(-sum));
                outputderivative[layer][neuron]=outputs[layer][neuron]*(1-outputs[layer][neuron]);
            }
        }
        return outputs[networkSize-1];
    }

    public void train(double[]input,double[]target,double rate)
    {
        //if(input.length!=inputSize||target.length!=outputSize)return;
        calculate(input);
        backPropError(target);
        updateWeights(rate);
    }

    public void backPropError(double[] target) {
        for (int neuron = 0; neuron < outputSize; neuron++)
        {
            errorsignal[networkSize - 1][neuron] = (outputs[networkSize - 1][neuron] - target[neuron])
                    * outputderivative[networkSize-1][neuron];
        }
        for (int layer = networkSize - 2; layer > 0; layer--)
        {
            for (int neuron = 0; neuron < layerSize[layer]; neuron++)
            {
                double sum = 0;
                for (int nextneuron = 0; nextneuron < layerSize[layer + 1]; nextneuron++)
                {
                    sum += weights[layer + 1][nextneuron][neuron] * errorsignal[layer + 1][nextneuron];
                }
                this.errorsignal[layer][neuron] = sum * outputderivative[layer][neuron];
            }
        }
    }

    public void updateWeights(double rate)
    {
        for(int layer=1;layer<networkSize;layer++)
        {
            for(int neuron=0;neuron<layerSize[layer];neuron++)
            {
                for(int prevneuron=0;prevneuron<layerSize[layer-1];prevneuron++)
                {
                    double delta = -rate * outputs[layer-1][prevneuron] * errorsignal[layer][neuron];
                    weights[layer][neuron][prevneuron]+=delta;
                }
                double delta = -rate * errorsignal[layer][neuron];
                bias[layer][neuron]+=delta;
            }
        }
    }

    public static void main(String[] args)
    {
        //Parameters you can change for the network
        double input[]=new double[]{1,4,6,7,2,3,4,5,6,4,4,3,3,33,3,5,5,6,7,1,2,3,4,5,6,7,2,1,2,4,5,6};
        double target[]=new double[]{1,0};
        double rate=.4;
        int iterations=100000;
        Network net = new Network(input.length,15,8,3,2);

        //trains the network
        for(int i=0;i<iterations;i++) net.train(input,target,rate);

        //prints the network
        System.out.println(Arrays.toString(net.calculate(input)));
    }



}

